import {Component} from '@angular/core';
import {Router} from '@angular/router'
import {UserService} from './user.service'
import {User} from './user'
import {ServerResponse} from "../serverresponse";

@Component({
  selector: 'app-root',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  title = 'User Registration';
  users;
  user = new User(0, "", "", "", null);

  constructor(private userService:UserService, private router:Router)
  {
    userService.getUsers().subscribe((data:ServerResponse) => {
      if(data.success)
        this.users = data.responseObject;
    },
    error => console.log(error));
  }

  public addUser()
  {
    this.userService.addUser(this.user).subscribe((result) =>
    {
      if(result) {
        this.user = new User(0, "", "", "", null);
        this.router.navigateByUrl('/outcomes');
      }
      else
      {
        console.log("Error in adding user")
      }
    });
  }

  public removeUser(userToDelete:User)
  {
    this.userService.removeUser(userToDelete).subscribe((result) => {
      if (result)
      {
        this.userService.getUsers().subscribe((data:ServerResponse) => {
          if(data.success)
            this.users = data.responseObject;
        }, error => console.log(error));
      }
    });
  }
}
