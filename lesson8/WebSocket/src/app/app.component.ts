import {Component, OnInit} from '@angular/core';
import {WebSocketAPI} from './WebSocketAPI';
import {FormArray, FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular8-springboot-websocket';

  webSocketAPI1: WebSocketAPI;
  webSocketAPI2: WebSocketAPI;
  webSocketAPI3: WebSocketAPI;
  greeting: any;
  name: string;
  connected1 = false;
  connected2 = false;
  connected3 = false;

  messages: FormGroup;

  constructor(private fb: FormBuilder) {
    this.messages = this.fb.group({
      Rows: this.fb.array([])
    });
  }

  get formArr() {
    return this.messages.get('Rows') as FormArray;
  }

  initRows(message) {
    return this.fb.group({
      name: [message]
    });
  }

  addNewRow(message) {
    this.formArr.push(this.initRows(message));
  }

  ngOnInit() {
    this.webSocketAPI1 = new WebSocketAPI(this, 'http://192.168.1.206:8080/gs-guide-websocket');
    this.webSocketAPI2 = new WebSocketAPI(this, 'http://192.168.1.224:8080/ws-cserver');
    this.webSocketAPI3 = new WebSocketAPI(this, 'http://192.168.1.64:8080/andrey-websocket');
  }

  connect1() {
    this.webSocketAPI1._connect();
    this.connected1 = true;
  }

  disconnect1() {
    this.webSocketAPI1._disconnect();
    this.connected1 = false;
  }

  connect2() {
    this.webSocketAPI2._connect();
    this.connected2 = true;
  }

  disconnect2() {
    this.webSocketAPI2._disconnect();
    this.connected2 = false;
  }

  connect3() {
    this.webSocketAPI3._connect();
    this.connected3 = true;
  }

  disconnect3() {
    this.webSocketAPI3._disconnect();
    this.connected3 = false;
  }

  sendMessage() {
    let num = Math.floor(Math.random() * 3);
    if (this.name.toUpperCase().startsWith('A')) {
      num = 3;
    }
    console.log('Send to Server' + (num + 1));
    switch (num) {
      case 0: {
        this.webSocketAPI1._send(this.name);
        break;
      }
      case 1: {
        this.webSocketAPI2._send(this.name);
        break;
      }
      case 2: {
        this.webSocketAPI3._send(this.name);
        break;
      }
    }
  }

  handleMessage(message) {
    const JSobj = JSON.parse(message);
    console.log('handleMessage ' + JSobj.content);
    this.addNewRow(JSobj.content);
    console.log(this.messages.controls.Rows);
    this.greeting = message;
  }
}
