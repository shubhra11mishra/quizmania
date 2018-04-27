import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute, Params } from "@angular/router";
import { Observable } from "rxjs/Observable";

@Component({
  selector: "app-examiner-dashboard",
  templateUrl: "./examiner-dashboard.component.html",
  styleUrls: ["./examiner-dashboard.component.css"]
})
export class ExaminerDashboardComponent implements OnInit {
  userId = "";

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.userId = params["userid"];
      console.log(this.userId);
    });
  }
}
