import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class DiagnosticCentre {
  constructor(
    public centreName: string,
    public centreId: string,
    public listOfTests: any,
  ) { }
}
export class DiagnosticCentres {
  constructor(
    public centreName: string,
    public testName: string,
    public testId: string
  ) { }
}
export class Test {
  constructor(
    public testId: string,
    public testName: string) {
  }
}

export class Appointment {
  constructor(
    public dateTimeSlot: string,
    public approved: boolean,
    public userId: string,
    public test: any,
    public center: any) { }
}
@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) {
  }
  getCentres() {
    return this.httpClient.get<DiagnosticCentre[]>("http://localhost:7871/DiagnosticCentre/find");
  }
  public deletecentre(centreId) {
    return this.httpClient.delete<DiagnosticCentre>("http://localhost:7871/DiagnosticCentre/delete/" + centreId);
  }
  public createcentre(diagnosticCentre) {
    return this.httpClient.post<any>("http://localhost:7871/DiagnosticCentre/create", diagnosticCentre);
  }
  getCentre() {
    return this.httpClient.get<any[]>("http://localhost:8033/Test/find");
  }
  public deleteTest(testId) {
    console.log(testId);
    return this.httpClient.delete<DiagnosticCentres>("http://localhost:8033/Test/delete/" + testId);

  }
  public createTest(diagnosticCentre) {
    const dataToSend: any = {

      "testName": diagnosticCentre.testName,
      "centre": {
        "centreName": diagnosticCentre.centreName
      }

    };
    return this.httpClient.post<any>("http://localhost:8033/Test/create", dataToSend);

  }

  public getCenterNames() {
    return this.httpClient.get<any>("http://localhost:8033/Test/findCentre");
  }


  public displayCenters() {
    return this.httpClient.get<DiagnosticCentre>("http://localhost:1111/User/FetchCenterList");
  }
  public displayTests(selectedCenterId) {
    console.log(selectedCenterId)
    return this.httpClient.get<Test>("http://localhost:1111/User/FetchTestList/" + selectedCenterId, { responseType: 'json' });

  }
  public makeAppointment(app) {

    return this.httpClient.post<any>("http://localhost:1111/User/makeAppointment", app, { responseType: 'json' });

  }
  public displayAppointments() {
    return this.httpClient.get<Appointment>("http://localhost:1111/User/FetchAppList");
  }

  public approveAppointment(app) {
    return this.httpClient.put<any>("http://localhost:1112/Admin/approveAppointment", app, { responseType: 'json' });

  }
}