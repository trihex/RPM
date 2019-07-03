import {Component} from '@angular/core';
import {UserService} from './user/user.service';
import {User} from './user/user';
import {ServerResponse} from "./serverresponse";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'User Registration';
  users;
  user = new User(0, '', '', '', null);

  constructor(private userService: UserService) {
    userService.getUsers().subscribe((data: ServerResponse) => {
      if(data.success)
        this.users = data;
    }, error => console.log(error));
  }

  public addUser() {
    this.userService.addUser(this.user).subscribe((result) => {
      if (result) {
        this.user = new User(0, '', '', '', null);
      }
    });
  }

  public removeUser(userToDelete: User) {
    this.userService.removeUser(userToDelete).subscribe((result) => {
      if (result) {
        this.userService.getUsers().subscribe((data: ServerResponse) => {
          if(data.success)
            this.users = data.responseObject;
        }, error => console.log(error));
      }
    });
  }
}
