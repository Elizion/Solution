export class Authorized {

  public id: number
  public name: string
  public codeStatus: string
  public createdAt: Date
  public modifiedAt: Date

  constructor(
    
    id?: number, 
    name?: string,
    codeStatus?: string,
    createdAt?: Date,
    modifiedAt?: Date) {

      this.id = id
      this.name = name
      this.codeStatus = codeStatus
      this.createdAt = createdAt
      this.modifiedAt = modifiedAt
  }

}
