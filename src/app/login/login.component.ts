import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { CommonService } from '../common.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  activeTab: string = 'login';

  loginData: any = {};

  signupData: any = {};

  data: any = {};

  constructor(private common: CommonService, private router: Router) {

  }
  showModal = false;

  // Toggle SignUp modal display
  toggleModal(mode: 'show' | 'hide') {
    this.showModal = (mode === 'show');
  }

  login() {
    this.common.postRequest(this.common.SERVER_URLS['LOGIN'], this.loginData).subscribe(
      (response) => {
        this.data = response;
        if (this.data.status == 200) {
          this.router.navigate(['/content']);
          localStorage.setItem("userInfo", this.data.result);
          Swal.fire({
            title: 'Success!',
            text: this.data.message,
            icon: 'success',
            confirmButtonText: 'Cool'
          });
        } else {
          Swal.fire({
            title: 'Error!',
            text: this.data.message,
            icon: 'error',
            confirmButtonText: 'Try Again'
          });
        }
      },
      (error) => {
        Swal.fire({
          title: 'Error!',
          text: 'An error occurred during sign-up!',
          icon: 'error',
          confirmButtonText: 'Try Again'
        });
      }
    );
  
  }
  signUp() {
    // Call the postRequest method with the appropriate endpoint and user data
    this.common.postRequest(this.common.SERVER_URLS['SIGN_UP'], this.signupData).subscribe(
      (response) => {
        this.data = response;
        if (this.data.status == 200) {
          this.router.navigate(['/content']);
          localStorage.setItem("userInfo", this.data.result);
          Swal.fire({
            title: 'Success!',
            text: this.data.message,
            icon: 'success',
            confirmButtonText: 'Cool'
          });
        } else {
          Swal.fire({
            title: 'Error!',
            text: this.data.message,
            icon: 'error',
            confirmButtonText: 'Try Again'
          });
        }
      },
      (error) => {
        Swal.fire({
          title: 'Error!',
          text: 'An error occurred during sign-up!',
          icon: 'error',
          confirmButtonText: 'Try Again'
        });
      }
    );
  }
}