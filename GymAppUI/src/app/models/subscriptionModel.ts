export class Subscription{
  subscriptionId: number;
  name: string;
  price: number;
  start: Date;
  duration: number;
  


  constructor(
    name: string,
    price: number,
    start: Date,
    duration: number) {
    this.name = name;
    this.price = price;
    this.start = start;
    this.duration = duration;
  }

  
}
