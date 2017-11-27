export class Subscription{
  subscriptionId: number;
  name: string;
  price: number;
  duration: number;
  


  constructor(
    name: string,
    price: number,
    duration: number) {
    this.name = name;
    this.price = price;
    this.duration = duration;
  }

  
}
