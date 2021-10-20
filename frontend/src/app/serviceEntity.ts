import { Time } from "@angular/common";
import { Url } from "url";

export interface ServiceEntity {
    id: number;
    serviceName: string;
    creationTime: Time;
    serviceUrl: string;
    httpStatus: string;
}