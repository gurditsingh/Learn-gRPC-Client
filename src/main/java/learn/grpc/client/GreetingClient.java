package learn.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import learn.grpc.proto.code.GreetingGrpc;
import learn.grpc.proto.code.GreetingOuterClass;

public class GreetingClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();

        GreetingGrpc.GreetingBlockingStub stub = GreetingGrpc.newBlockingStub(channel);

        GreetingOuterClass.APIRequest request=GreetingOuterClass.APIRequest.newBuilder().setName("Bisman Kaur").build();

        GreetingOuterClass.APIResponse response = stub.sayHello(request);

        System.out.println(response.getResponsemessage());
    }
}
