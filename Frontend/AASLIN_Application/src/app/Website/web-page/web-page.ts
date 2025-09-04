import { Component } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { RouterLinkActive } from '@angular/router';
import { MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
@Component({
  selector: 'app-web-page',
  imports: [MatGridListModule,MatCardModule,MatToolbarModule,RouterLink,RouterLinkActive,MatButtonModule],
  templateUrl: './web-page.html',
  styleUrl: './web-page.css'
})
export class WebPage {

}
