import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private authService: AuthService, private router:Router) { }
  user: any
  username!: string

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("user") || "")
    console.log(this.user)
    this.username = this.user.username
  }

  logout(): void {
    this.authService.logout().subscribe(
        response => {
            localStorage.clear();
            this.router.navigate(["/login"])
        },
        error => {
            console.error("Error de logout", error);
        }
    );
}



}
