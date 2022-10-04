export class ActivityModel {

  public title: string
  public message: string
  public module: string  
  public idUser: number
  public fullNameUser: string
  public createdAt: Date
  public dateString: string

  constructor(
    title?: string,
    message?: string,
    module?: string,
    idUser?: number,
    fullNameUser?: string,
    createdAt?: Date,
    dateString?: string) {
      this.title = title
      this.message = message
      this.module = module
      this.idUser = idUser
      this.fullNameUser = fullNameUser
      this.createdAt = createdAt
      this.dateString = dateString
  }
  
}
