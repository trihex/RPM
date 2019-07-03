import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {User} from "./user";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ServerResponse} from "../serverresponse";

@Injectable()
export class UserService {
  constructor(private _http: HttpClient) {
  }

  public login(user: User): Observable<ServerResponse> {
    const headers = new HttpHeaders();
    headers.append('Accept', 'application/json;charset=utf-8');
    return this._http.put<ServerResponse>('http://localhost:8080/user', user, {headers: headers});
  }

  public getUsers(): Observable<ServerResponse> {
    const headers = new HttpHeaders();
    headers.append('Accept', 'application/json;charset=utf-8');
    return this._http.get<ServerResponse>('http://localhost:8080/user', {headers: headers});
  }

  public addUser(user: User): Observable<ServerResponse> {
    const headers = new HttpHeaders();
    headers.append('Accept', 'application/json;charset=utf-8');
    return this._http.post<ServerResponse>('http://localhost:8080/user', user, {headers: headers});
  }

  public removeUser(user: User): Observable<ServerResponse> {
    const headers = new HttpHeaders();
    headers.append('Accept', 'application/json;charset=utf-8');
    return this._http.delete<ServerResponse>('http://localhost:8080/user/' + user.id, {headers: headers});
  }
}
