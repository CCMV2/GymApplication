export class User{
    id: number;
    password: string;
    name: string;
    surname: string;
    email: string;
    phonenumber: string;
    userPermission: string;
  
    constructor(id: number, password: string, name: string, surname: string, email: string, phonenumber: string, userPermission: string) {
      this.id = id;
      this.password = password;
      this.name = name;
      this.surname = surname;
      this.email = email;
      this.phonenumber = phonenumber;
      this.userPermission = userPermission;
    }
    
  }
  