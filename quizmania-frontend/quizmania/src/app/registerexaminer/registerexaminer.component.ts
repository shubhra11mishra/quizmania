import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { RegisterExaminerService } from './registerexaminer.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registerexaminer',
  templateUrl: './registerexaminer.component.html',
  styleUrls: ['./registerexaminer.component.css']
})
export class RegisterexaminerComponent implements OnInit {

  successfull= false;

  user:User = new User();

  constructor(private registerExaminerService: RegisterExaminerService) { }

  ngOnInit() {
  }

  registerExaminer(form: NgForm){
    this.user.userFirstName = form.value.firstname;
    this.user.userLastName = form.value.lastname;
    this.user.email = form.value.inputEmail;
    this.user.password = form.value.inputPassword;
    this.user.userType = "EXAMINER";
    form.reset();
    this.registerExaminerService.registerExaminer(this.user)
      .subscribe(
        (response) => {this.successfull = true},
        (error) => console.log(error)
      );
  }
}
