import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { NgForm, FormGroup, Validators, FormControl } from '@angular/forms';
import { RegisterExamineeService } from './registerexaminee.service';

@Component({
  selector: 'app-registerexaminee',
  templateUrl: './registerexaminee.component.html',
  styleUrls: ['./registerexaminee.component.css']
})
export class RegisterexamineeComponent implements OnInit {

  registerExamineeForm: FormGroup;
  successfull= false;

  user:User = new User();

  constructor(private registerExamineeService: RegisterExamineeService) { }

  ngOnInit() {
    this.registerExamineeForm = new FormGroup({
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

  registerExaminee(){
    this.user.userFirstName = this.registerExamineeForm.value.firstName;
     this.user.userLastName = this.registerExamineeForm.value.lastName;
     this.user.email = this.registerExamineeForm.value.inputEmail;
     this.user.password = this.registerExamineeForm.value.passwordGroup.inputPassword;
     this.user.userType = "EXAMINEE";
    this.registerExamineeForm.reset();
    this.registerExamineeService.registerExaminee(this.user)
      .subscribe(
        (response) => {this.successfull = true},
        (error) => console.log(error)
      );
  }

}
