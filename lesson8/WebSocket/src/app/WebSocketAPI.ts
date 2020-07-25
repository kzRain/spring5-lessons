import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {AppComponent} from './app.component';

export class WebSocketAPI {
  webSocketEndPoint = 'http://localhost:8080/gs-guide-websocket';
  topic = '/topic/greetings';
  stompClient: any;
  appComponent: AppComponent;

  constructor(appComponent: AppComponent,
              webSocketEndPoint: string) {
    this.appComponent = appComponent;
    if (webSocketEndPoint !== '') {
      this.webSocketEndPoint = webSocketEndPoint;
    }
  }

  _connect() {
    console.log('Initialize WebSocket Connection');
    const ws = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(ws);
    const localthis = this;
    localthis.stompClient.connect({}, frame => {
      localthis.stompClient.subscribe(localthis.topic, sdkEvent => {
        localthis.onMessageReceived(sdkEvent);
      });
      //localthis.stompClient.reconnect_delay = 2000;
    }, this.errorCallBack);
    console.log('Connected!!!!')
  }

  _disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconnect();
    }
    console.log('Disconnected');
  }

  // on error, schedule a reconnection attempt
  errorCallBack(error) {
    console.log('errorCallBack -> ' + error);
    setTimeout(() => {
      this._connect();
    }, 5000);
  }


  _send(message) {
    console.log('calling logout api via web socket');
    this.stompClient.send('/app/topic', {}, JSON.stringify(message));
  }

  onMessageReceived(message) {
    console.log('Message Recieved from Server :: [' + message.body + ']');
    this.appComponent.handleMessage(message.body);
  }
}
