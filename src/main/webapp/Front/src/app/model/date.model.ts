import * as moment from "moment";

export class DateModel {

  public dateMoment: moment.Moment
  public date: Date
  public dateAsDouble: number
  public isValidateDate: boolean
  
  constructor(
    dateMoment?: moment.Moment,
    date?: Date,
    dateAsDouble?: number,
    isValidateDate?: boolean) {
      this.dateMoment = dateMoment
      this.date = date
      this.dateAsDouble = dateAsDouble
      this.isValidateDate = isValidateDate
  }
  
}
