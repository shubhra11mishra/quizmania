import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { RegisterExaminerService } from './registerexaminer.service';
import { NgForm, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-registerexaminer',
  templateUrl: './registerexaminer.component.html',
  styleUrls: ['./registerexaminer.component.css']
})
export class RegisterexaminerComponent implements OnInit {

  registerExaminerForm: FormGroup;
  successfull= false;

  user:User = new User();

  constructor(private registerExaminerService: RegisterExaminerService) { }

  ngOnInit() {
    this.registerExaminerForm = new FormGroup({
      'firstName': new FormControl('' ,[Validators.required]),
      'lastName': new FormControl(null,[Validators.required]),
       'inputEmail': new FormControl(null,[Validators.required, Validators.email]),
       'passwordGroup' : new FormGroup
       (
         {
        'inputPassword': new FormControl(null,[Validators.required, Validators.minLength(8)]),
        'confirmPassword': new FormControl(null,[Validators.required, Validators.minLength(8)])
        },
        [this.passwordsMatch]
      )
    });
  }

  passwordsMatch(passwordGroup: FormGroup): {[s: string] : boolean}{
    if(passwordGroup.get('inputPassword').value !== passwordGroup.get('confirmPassword').value){
      return {'passwordsDoNotMatch':true};
    }
    return null;
  }

  registerExaminer(){
    this.user.userFirstName = this.registerExaminerForm.value.firstName;
     this.user.userLastName = this.registerExaminerForm.value.lastName;
     this.user.email = this.registerExaminerForm.value.inputEmail;
     this.user.password = this.registerExaminerForm.value.passwordGroup.inputPassword;
     this.user.userType = "EXAMINER";
    this.registerExaminerForm.reset();
    this.registerExaminerService.registerExaminer(this.user)
      .subscribe(
        (response) => {this.successfull = true},
        (error) => console.log(error)
      );
  }
}
