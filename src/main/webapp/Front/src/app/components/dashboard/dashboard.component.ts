import { Component, OnInit } from '@angular/core'
import { UserModel } from 'src/app/model/user.model'
import { ChartDataSets, ChartOptions, ChartType, RadialChartOptions } from 'chart.js'
import { Label } from 'ng2-charts'
import { DashboardService } from 'src/app/services/dashboard.service'
import { AlertService } from 'src/app/services/alert.service'
import { AlertConstants } from 'src/app/config/alert.constants'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  userModel = new UserModel()
  timezone: string
  listFake: []
  listFakeAdd: []

  constructor(private dashboardService: DashboardService, private alertService: AlertService) { }
    
  ngOnInit(): void {    
    this.userModel = JSON.parse(sessionStorage.getItem('userdetails'))
    this.timezone = JSON.parse(sessionStorage.getItem('timezone'))          
    this.dashboardService.getApiFake().subscribe(        
      responseData => {              
        this.listFake = responseData.body as []          
      }, error => {
        alert(error.error.message)
      }
    )
  }

  pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    tooltips: {
      enabled: true,
      mode: 'single',
      callbacks: {
        label: function (tooltipItems, data) {
          return data.datasets[0].data[tooltipItems.index] + ' %'
        }
      }
    },
  }

  pieChartLabels: Label[] = ['Nitrogen', 'Oxygen', 'Argon', 'Carbon dioxide']
  pieChartData: number[] = [78.09, 20.95, 0.93, 0.03]
  pieChartType: ChartType = 'pie'
  pieChartLegend = true
  pieChartPlugins = []
  pieChartColors = [
    {
      backgroundColor: ['rgba(255,0,0,0.3)', 'rgba(0,255,0,0.3)', 'rgba(0,0,255,0.3)'],
    },
  ]

  public radarChartOptions: RadialChartOptions = {
    responsive: true,
  }

  public radarChartLabels: Label[] = ['Estabilidad', 'Soporte', 'Estres', 'Memoria', 'Facturación', 'Workers', 'Loaders']

  public radarChartData: ChartDataSets[] = [
    { data: [100, 93, 97, 95, 95, 95, 99], label: 'Desarrollador' },
    { data: [91, 70, 95, 90, 91, 93, 96], label: 'Funcional' }
  ]
  
  public radarChartType: ChartType = 'radar'

  public doughnutChartLabels = ['Q1 Growth', 'Q2 Growth', 'Q3 Growth', 'Q4 Growth']
  public doughnutChartData = [80, 83, 94, 87]
  public doughnutChartType = 'doughnut'

  bubbleChartOptions: ChartOptions = {
    responsive: true,
    scales: {
      xAxes: [{
        ticks: {
          min: 0,
          max: 100,
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 100,
        }
      }]
    }
  }
  public bubbleChartType: ChartType = 'bubble'
  public bubbleChartLegend = true

  public bubbleChartData: ChartDataSets[] = [
    {
      data: [
        { x: 45, y: 25, r: 15 },
        { x: 55, y: 15, r: 25 },
        { x: 36, y: 22, r: 33 },
        { x: 40, y: 28, r: 32 },
      ],
      label: 'Equities Deatil',
    },
  ]

}
