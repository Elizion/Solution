export class Authenticated {

  public uuid: string;
  public name: string;
  public codeStatus: string;
  public createdAt: Date;
  public modifiedAt: Date;

  constructor(
    
    uuid?: string, 
    name?: string,
    codeStatus?: string,
    createdAt?: Date,
    modifiedAt?: Date) {

      this.uuid = uuid;
      this.name = name;
      this.codeStatus = codeStatus;
      this.createdAt = createdAt;
      this.modifiedAt = modifiedAt;
  }

}
