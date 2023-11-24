import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user:any
  username!:string
 ngOnInit(): void {
  this.user=JSON.parse(localStorage.getItem("user")||"")
  console.log(this.user)
  this.username=this.user.username
 }
  
 logout():void{
  
 }
 
 
}
