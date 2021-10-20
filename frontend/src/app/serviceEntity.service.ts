import { Injectable } from "@angular/core";
import {HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { ServiceEntity } from "./serviceEntity";


@Injectable({
    providedIn: 'root'
}
)
export class ServiceEntityService{

    private apiUrl = 'http://localhost:8080';
    options = {'access-control-allow-origin': "http://localhost:4200/", 'Content-Type': 'application/json'} ;

    constructor(private http: HttpClient){}

    public getServices():Observable<ServiceEntity[]>{
        return this.http.get<ServiceEntity[]>(`${this.apiUrl}/api/services`);
    }

    public addService(service: ServiceEntity): Observable<ServiceEntity>{
        return this.http.post<ServiceEntity>(`${this.apiUrl}/api/services/add`, service);
    }



    public updateService(service : ServiceEntity):Observable<ServiceEntity>{
        return this.http.put<ServiceEntity>(`${this.apiUrl}/api/services/update`, service);
    }

    public deleteService(serviceId : number):Observable<void>{
        return this.http.delete<void>(`${this.apiUrl}/api/services/delete/${serviceId}`);
    }

}