import { Component, Inject } from '@angular/core';
import { ServiceEntity } from './serviceEntity';
import { MatTableDataSource} from '@angular/material/table';
import { ServiceEntityService } from './serviceEntity.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  public serviceEntities: ServiceEntity[];

  displayedColumns:  string[] = ['Service Name', 'Service URL', 'Created', 'Http Status', 'Edit Service'];
  dataSource = new MatTableDataSource<ServiceEntity>();
  service = <ServiceEntity>{};

  constructor(
    private serviceEntityService: ServiceEntityService,
    public dialog: MatDialog

  ){}

  ngOnInit(): void {
    this.serviceEntityService.getServices().subscribe(
      services => {
        this.serviceEntities = services;
        this.dataSource.data = this.serviceEntities;
      }
    );
  }

  public onAddService(serviceEntity: ServiceEntity): void{
    this.serviceEntityService.addService(serviceEntity).subscribe(
      (response: ServiceEntity) => {
        console.log(response);
        this.ngOnInit();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
  public onUpdateService(serviceEntity: ServiceEntity): void{
    this.serviceEntityService.updateService(serviceEntity).subscribe(
      (response: ServiceEntity) => {
        console.log(response);
        this.ngOnInit();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteService(serviceEntity: ServiceEntity): void{
    this.serviceEntityService.deleteService(serviceEntity.id);
    this.ngOnInit();
  }

  editService(service: ServiceEntity) {
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: service
    });

    dialogRef.afterClosed().subscribe(result => {
      this.service = service;
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(NewServiceDialog, {
      width: '250px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result.data);
      this.onAddService(result.data);
    });
  }

}





@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: 'dialog.html',
})
export class DialogOverviewExampleDialog {
  serviceEntityService: ServiceEntityService;
  

  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: ServiceEntity) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}


@Component({
  selector: 'new-service-dialog',
  templateUrl: 'newservicedialog.html',
})
export class NewServiceDialog {
  serviceEntityService: ServiceEntityService;
  service: ServiceEntity;

  constructor(
    public dialogRef: MatDialogRef<NewServiceDialog>,
    @Inject(MAT_DIALOG_DATA) public data: ServiceEntity) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  onYesClick(){
    this.dialogRef.close({data: this.dialogRef.componentInstance.data});
  }
}


