import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { RegisterAdminService } from './registeradmin.service';

@Component({
  selector: 'app-registeradmin',
  templateUrl: './registeradmin.component.html',
  styleUrls: ['./registeradmin.component.css']
})
export class RegisteradminComponent implements OnInit {

  user:User = new User();
  successfull= false;
  constructor(private registerAdminService: RegisterAdminService) { }

  ngOnInit() {
  }

  registerAdmin(form: NgForm){
    this.user.userFirstName = form.value.firstname;
    this.user.userLastName = form.value.lastname;
    this.user.email = form.value.inputEmail;
    this.user.password = form.value.inputPassword;
    this.user.passcode = form.value.passcode;
    this.user.userType = "ADMIN";
    form.reset();
    this.registerAdminService.registerAdmin(this.user)
      .subscribe(
        (response) => {this.successfull = true},
        (error) => console.log(error)
      );
  }

}
