import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from '../user';
import { RegisterAdminService } from './registeradmin.service';

@Component({
  selector: 'app-registeradmin',
  templateUrl: './registeradmin.component.html',
  styleUrls: ['./registeradmin.component.css']
})
export class RegisteradminComponent implements OnInit {
  registerAdminForm: FormGroup;
  user:User = new User();
  successfull= false;
  invalidPasscode = false;
  constructor(private registerAdminService: RegisterAdminService) { }

  ngOnInit() {
    this.registerAdminForm = new FormGroup({
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
      ),
       'passcode': new FormControl(null,[Validators.required])
    });
  }

  passwordsMatch(passwordGroup: FormGroup): {[s: string] : boolean}{
    if(passwordGroup.get('inputPassword').value !== passwordGroup.get('confirmPassword').value){
      return {'passwordsDoNotMatch':true};
    }
    return null;
  }

  registerAdmin(){
    console.log(this.registerAdminForm);

     this.user.userFirstName = this.registerAdminForm.value.firstName;
     this.user.userLastName = this.registerAdminForm.value.lastName;
     this.user.email = this.registerAdminForm.value.inputEmail;
     this.user.password = this.registerAdminForm.value.passwordGroup.inputPassword;
     this.user.passcode = this.registerAdminForm.value.passcode;
    this.user.userType = "ADMIN";
    this.registerAdminService.registerAdmin(this.user)
      .subscribe(
        (response) => {
          if(response.json().userID===null){
            this.invalidPasscode = true;
          }else{
            this.registerAdminForm.reset();
            this.successfull = true;
          }
          
        },
        (error) => console.log(error)
      );
  }

}
