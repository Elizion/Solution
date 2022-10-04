import { Authenticated } from "./authenticated.model";
import { Authorized } from "./authorized.model";

export class UserModel {

  public id: number;
  public picture: string;
  public name: string;
  public lastName: string;
  public email: string;
  public password: string;
  public phone: string;
  public gender: number;
  public bornDate: Date;
  public bornStrDate: string;
  public isEnabled: boolean;
  public codeStatus: string;
  public createdAt: Date;
  public modifiedAt: Date;
  public listAuthorized: Array<Authorized> = [];
  public listAuthenticated: Array<Authenticated> = [];
  
  constructor(
    id?: number,
    picture?: string,
    name?: string,
    lastName?: string,
    email?: string,
    password?: string,
    phone?: string,
    gender?: number,
    bornDate?: Date,
    bornStrDate?: string,
    isEnabled?: boolean,
    codeStatus?: string,
    createdAt?: Date,
    modifiedAt?: Date,
    listAuthenticated?: Array<Authenticated>,
    listAuthorized?: Array<Authorized>) {
      this.id = id;
      this.picture = picture;
      this.name = name;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
      this.phone = phone;
      this.gender = gender;      
      this.bornDate = bornDate;
      this.bornStrDate = bornStrDate;
      this.isEnabled = isEnabled;
      this.codeStatus = codeStatus;
      this.createdAt = createdAt;
      this.modifiedAt = modifiedAt;      
      this.listAuthenticated = listAuthenticated;
      this.listAuthorized = listAuthorized;
  }
  
}
