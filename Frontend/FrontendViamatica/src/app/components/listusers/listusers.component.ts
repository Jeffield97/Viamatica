import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-listusers',
  templateUrl: './listusers.component.html',
  styleUrls: ['./listusers.component.css']
})
export class ListusersComponent implements OnInit{
  constructor(private dataService: DataService) {}
  data!: any[];

  ngOnInit(): void {
    this.getData()
  }
  getData() {
    this.dataService.getData().subscribe(
      (response) => {
        this.data = response;
        console.log('Data received:', this.data);
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }

}
