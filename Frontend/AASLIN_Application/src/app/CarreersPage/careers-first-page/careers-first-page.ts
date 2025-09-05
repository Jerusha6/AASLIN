import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-careers-first-page',
  imports: [MatCardModule, MatButtonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './careers-first-page.html',
  styleUrl: './careers-first-page.css'
})
export class CareersFirstPage {
searchJob:FormGroup=new FormGroup({
  title:new FormControl('')
});
footerForm:FormGroup=new FormGroup({
name:new FormControl('',Validators.required),
email:new FormControl('',[Validators.required,Validators.pattern("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")]),
subject:new FormControl('',Validators.required),
message:new FormControl('',Validators.required)
});


private _snackBar = inject(MatSnackBar);
  onSubmit(): void {
    
    if(this.footerForm.valid){
    this._snackBar.open('Message sent!!', 'Close')
    this.footerForm.reset();
    }
    else{
      console.log("invalid");
    }
  }


}
