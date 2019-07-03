import {Component} from '@angular/core';
import {User} from '../user/user';
import {Router} from '@angular/router';
import {UserService} from '../user/user.service';
import {LocalStorageService} from "angular-web-storage";

@Component({
  selector: 'app-root',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  user = new User(0, '', '', '', null);

  constructor(private userService: UserService, private router: Router, private storage: LocalStorageService) {
  }

  public register() {
    this.userService.addUser(this.user).subscribe((result) => {
      if (result.success) {
        this.storage.set("user", result.responseObject);
        this.user = new User(0, '', '', '', null);
        this.router.navigateByUrl('/outcomes');
      } else {
        console.log('Error in adding user');
      }
    });
  }
}
