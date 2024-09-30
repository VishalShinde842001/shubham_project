import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  public baseUrl = 'http://localhost:8080/rest/';
  public SERVER_URLS: any = {
    "SIGN_UP": "sign-up",
    "LOGIN": "login",
    "ALL_TOPICS": "all-topics",
    "TOPIC_INFO": "topic-information-"
  }

  constructor(private httpClient: HttpClient) { }

  getRequest(url: string): Observable<any> {
    const fullUrl = `${this.baseUrl}${url}`; // Construct the full URL
    return this.httpClient.get<any>(fullUrl);
  }

  postRequest(url: string, payload: any): Observable<any> {
    const fullUrl = `${this.baseUrl}${url}`; // Construct the full URL
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<any>(fullUrl, payload, { headers });
  }

  putRequest(url: string, payload: any): Observable<any> {
    const fullUrl = `${this.baseUrl}${url}`; // Construct the full URL
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put<any>(fullUrl, payload, { headers });
  }

  deleteRequest(url: string): Observable<any> {
    const fullUrl = `${this.baseUrl}${url}`; // Construct the full URL
    return this.httpClient.delete<any>(fullUrl);
  }
}
