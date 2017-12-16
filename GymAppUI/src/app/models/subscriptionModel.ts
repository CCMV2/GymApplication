import {Rating} from "./rating";
export class Subscription{
  subscriptionId: number;
  name: string;
  price: number;
  duration: number;
  rat: Rating;
  stars: any;
	imageBase64: String;

  


  constructor(
    name: string,
    price: number,
    duration: number,
    imageBase64:String,
    ) {
    this.name = name;
    this.price = price;
    this.duration = duration;
    this.imageBase64 = imageBase64;
  }

  
}
