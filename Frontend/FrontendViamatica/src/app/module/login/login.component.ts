import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';
import { User } from '../../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user: User = {
    username: 'JeffieldFullbuster97',
    password: 'P@ssword1234'
  };

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.user).subscribe(
      response => {
        //save the token and user in localStorage
        localStorage.setItem("user",JSON.stringify(response.user))
        localStorage.setItem("token",response.token)
  
        // Redirect to dashboard route
        this.router.navigate(['/dashboard']);
      },
      error => {
        // Manejar el error (credenciales incorrectas, usuario bloqueado, etc.)
        console.error('Error de login:', error);
      }
    );
  }
}
