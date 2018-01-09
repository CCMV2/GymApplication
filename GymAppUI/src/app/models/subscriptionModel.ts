import {Rating} from "./rating";
export class Subscription{
  subscriptionId: number;
  name: string;
  price: number;
  duration: number;
  rat: Rating;
  stars: any;
	imageBase64: string;

  


  constructor(
    name: string,
    price: number,
    duration: number,
    imageBase64:string,
    ) {
    this.name = name;
    this.price = price;
    this.duration = duration;
    this.imageBase64 = imageBase64;
  }

  
}
