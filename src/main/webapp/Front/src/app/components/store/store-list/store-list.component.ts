import { Component, OnInit } from '@angular/core'
import { AlertService } from 'src/app/services/alert.service'
import { StoreService } from 'src/app/services/store.service'
import { MaterialService } from 'src/app/services/material.service'
import { PriceService } from 'src/app/services/price.service'
import { AlertConstants } from 'src/app/config/alert.constants'
import * as moment from 'moment-timezone'
import { CONFIG } from '../../../config/config.constants'

@Component({
  selector: 'app-store-list',
  templateUrl: './store-list.component.html',
  styleUrls: ['./store-list.component.css']
})
export class StoreListComponent implements OnInit {
  
  date: any
  price: any

  idStore: any
  listStore: any
  storePrices: any
  storePrice: any

  nameStore: any
  timezone: any

  materialsArray: any
  materials: any
  units: any

  selectedIdMaterial: any
  selectedIdUnit: any

  idPrice: any
  storeTypes: any
  selectedIdStoreType: any

  constructor(private alertService: AlertService, private storeService: StoreService, private materialService: MaterialService, private priceService: PriceService) { 
    
    this.materialChanged(CONFIG.MATERIAL_DEFAULT)
    this.unitChanged(CONFIG.UNIT_DEFAULT)
    this.storeTypeChanged(CONFIG.STORE_TYPE_DEFAULT)

  }

  ngOnInit(): void {

    this.timezone = JSON.parse(sessionStorage.getItem('timezone'))

    this.storeService.getListStore().subscribe(      
      responseData => {     
        this.listStore = responseData.body['data']
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
  
    let myModalStorePrices = document.getElementById('getStorePrices')

    myModalStorePrices.addEventListener('shown.bs.modal', function () {
      myModalStorePrices.focus()
    })

    let myModalCreatedStorePrices = document.getElementById('createdStorePrice')

    myModalCreatedStorePrices.addEventListener('shown.bs.modal', function () {
      myModalCreatedStorePrices.focus()
    })
    
    let myModalModifiedStorePrices = document.getElementById('modifiedStorePrice')
    
    myModalModifiedStorePrices.addEventListener('shown.bs.modal', function () {
      myModalModifiedStorePrices.focus()
    })
        
    let myModalDeletedStorePrices = document.getElementById('deletedStorePrice')
    
    myModalDeletedStorePrices.addEventListener('shown.bs.modal', function () {
      myModalDeletedStorePrices.focus()
    })

  }

  getMaterials(): void {
    this.materialService.getMaterials().subscribe(                  
      responseData => {                     
        this.materials = responseData.body['data']     
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
  }

  getUnits(): void {
    this.materialService.getUnits().subscribe(                  
      responseData => {                     
        this.units = responseData.body['data']     
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
  }

  getStoreTypes(): void {
    this.storeService.getStoreTypes().subscribe(                  
      responseData => {                     
        this.storeTypes = responseData.body['data']     
      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }
    )
  }


  materialChanged(idMaterial: number): void {
    this.selectedIdMaterial = idMaterial
  }

  unitChanged(idUnit: number): void {
    this.selectedIdUnit = idUnit
  }

  storeTypeChanged(idStoreType: number): void {
    this.selectedIdStoreType = idStoreType
  }
  
  getStorePrices(idStore: any): void {    
    this.idStore = idStore    
    this.storeService.getStorePrices(idStore).subscribe(            
      
      responseData => {             
        
        this.storePrices = responseData['data']
                
        for(let i = 0; i<this.storePrices.length; i++) {          
          this.storePrices[i].date = moment(this.storePrices[i].date).tz(CONFIG.TIME_ZONE_SERVER).format('YYYY-MMM-DD')
        }

      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }

    )    
  }

  getIdStore(idStore: any): void {    
    this.idStore = idStore    
    this.getMaterials()
    this.getUnits()
    this.getStoreTypes()
  }

  createdStorePrice(): void {
    
    let idStore = this.idStore
    let price = this.price
    let date = this.date
    let idMaterial = this.selectedIdMaterial
    let idUnit = this.selectedIdUnit
    let idStoreType = this.selectedIdStoreType
    const dt = new Date(date)

    const storePriceRequest = { "idStore": idStore, "idStoreType": idStoreType, "idMaterial": idMaterial, "idUnit": idUnit, "date": dt, "price": price }

    this.materialService.createdStorePrice(storePriceRequest).subscribe(      
      
      responseData => {     
        
        this.storePrice = responseData.body['data']
        this.alertService.showNotification('Precio creado con fecha ' + this.storePrice.date, "Success", AlertConstants.SUCCESS)

      }, error => {
        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)
      }

    )

  }
  
  modifiedStorePrice(price: any): void {    


    this.priceService.modifiedStorePrice(price).subscribe(            
      
      responseData => {             
        
        let response = responseData.body['data']       
        this.alertService.showNotification(response, "Success", AlertConstants.SUCCESS)   

      }, error => {

        this.alertService.showNotification(error.error.message, "Error", AlertConstants.ERROR)

      }

    )   

  }

}
