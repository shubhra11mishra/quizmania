import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-examinee-dashboard',
  templateUrl: './examinee-dashboard.component.html',
  styleUrls: ['./examinee-dashboard.component.css']
})
export class ExamineeDashboardComponent implements OnInit {

  userId = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.userId = params['userid'];
      console.log(this.userId);
    });
  }

}
