import { Component, signal } from '@angular/core';
import { RouterOutlet,RouterLinkActive, RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLinkActive,RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('AASLIN_Application');
}
