import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../shared/login/login.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  notfound: boolean;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {}

  login(form: NgForm) {
    this.user.email = form.value.inputEmail;
    this.user.password = form.value.inputPassword;
    form.reset();
    this.loginService.login(this.user).subscribe(
      response => {
        if (response.json().email === null) {
          this.notfound = true;
        } else {
          console.log(response.json().userType);
          if (response.json().userType === 'ADMIN') {
            const url = '/admin-dashboard/' + response.json().userID;
            this.router.navigate([url]);
          } else if (response.json().userType === 'EXAMINER') {
            console.log(response.json());
            const url = '/examiner-dashboard/' + response.json().userID;
            this.router.navigate([url]);
          }else if(response.json().userType === 'EXAMINEE'){
            console.log(response.json());
            const url = '/examinee-dashboard/' + response.json().userID;
            this.router.navigate([url]);
          }
        }
      },
      error => console.log(error)
    );
  }
}
