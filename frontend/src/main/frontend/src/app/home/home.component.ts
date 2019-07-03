import { Component } from '@angular/core';
import {User} from '../user/user';
import {UserService} from "../user/user.service";
import {ServerResponse} from "../serverresponse";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  title = 'Home';
  user = new User(0, '', '', '', null);

  public constructor(private userService:UserService, private router: Router){

  }

  public login() {
    console.log('Username ' + this.user.username);
    console.log('Password ' + this.user.password);

    this.userService.login(this.user).subscribe((response:ServerResponse) => {
      if(response.success)
        this.router.navigateByUrl('/outcomes');
    });
  }
}
