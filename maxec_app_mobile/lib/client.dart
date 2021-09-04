
import 'package:flutter/material.dart';
import 'package:graphql_flutter/graphql_flutter.dart';

class Config {
  static final String serverAddr = '10.0.2.2';
  //static final String serverAddr = 'localhost';
  static final String linkBase = 'http://$serverAddr:12000';
  static final String mediaBase = 'http://$serverAddr:9080/media';

  static final HttpLink httpLink = HttpLink(
    "http://$serverAddr:11000/graphql"
  );

  static final AuthLink authLink = AuthLink(getToken: () => 'Bearer 123456');

  static final Link link = authLink.concat(httpLink);

  static ValueNotifier<GraphQLClient> initializeClient() {
    ValueNotifier<GraphQLClient> client = ValueNotifier(
      GraphQLClient(
        link: link,
        cache: GraphQLCache(store: HiveStore())
      )
    );
    return client;
  }
}