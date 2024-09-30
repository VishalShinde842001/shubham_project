import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../common.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
declare var $: any; 
@Component({
  selector: 'app-content',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent implements OnInit {

  data: any = {};
  constructor(private router: Router, private common: CommonService,private sanitizer: DomSanitizer) {

  }
  ngOnInit(): void {
    this.checkUserAuth();
    this.getAllTopics();
  }

  topics: any = [];
  selectedTopic: any = {};
  topicInformation: any = [];
  getAllTopics() {
    this.common.getRequest(this.common.SERVER_URLS['ALL_TOPICS']).subscribe(
      (response) => {
        this.data = response;
        if (this.data.status == 200) {
          this.topics = this.data.result;
          this.selectTopic(this.topics[0]);
        }
      }, (error) => {

      }
    )
  }
  selectTopic(topic: any) {
    this.selectedTopic = topic;
    this.common.getRequest(this.common.SERVER_URLS['TOPIC_INFO'] + topic.topicId).subscribe((response) => {
      this.data = response;
      if (this.data.status == 200) {
        this.topicInformation = this.data.result;
      }
    })
  }

  // Check for user authentication
  checkUserAuth() {
    const userInfo = localStorage.getItem('userInfo');
    if (!userInfo) {
      // Redirect to login if userInfo is not found
      this.router.navigate(['/login']);
    }
  }
  logout() {
    this.router.navigate(['/login']);
    localStorage.clear();

  }
  getSafeHtml(content: string): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml(content);
  }
  startTest() {


  }
  openModal() {
    $('#myModal').modal('show'); 
  }
  closeModal(){
    $('#myModal').modal('hide');
  }
}
