import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
@Component({
  selector: 'app-careers-first-page',
  imports: [ MatCardModule,MatButtonModule],
  templateUrl: './careers-first-page.html',
  styleUrl: './careers-first-page.css'
})
export class CareersFirstPage {
searchJob:FormGroup=new FormGroup({
  title:new FormControl('')
});
}
