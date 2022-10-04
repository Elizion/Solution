export class ZoneModel {

    public id: number
    public zone: string
    public codeStatus: string
    public createdAt: Date
    public modifiedAt: Date
  
    constructor(
      
      id?: number, 
      zone?: string,
      codeStatus?: string,
      createdAt?: Date,
      modifiedAt?: Date) {
  
        this.id = id
        this.zone = zone
        this.codeStatus = codeStatus
        this.createdAt = createdAt
        this.modifiedAt = modifiedAt
    }
  
  }
  