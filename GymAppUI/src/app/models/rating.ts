export class Rating{
  idRating: number;
  total: number;
  nrpers: number;

  constructor(idRating:number,total:number,nrpers:number){
    this.idRating = idRating;
    this.total = total;
    this.nrpers = nrpers;
  }
}