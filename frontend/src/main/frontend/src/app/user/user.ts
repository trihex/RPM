export class User {
  id:number;
  username:string;
  password:string;
  email:string;
  registrationDate:Date;

  constructor(id:number, username:string, password:string, email:string, registrationDate:Date)
  {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.registrationDate = registrationDate;
  }
}
