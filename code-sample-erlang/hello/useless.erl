-module(useless).
-export([add/2, hello/0, greet_and_add_two/1]).

-define(KEK, some_value).

%% import format function
%% -import(io, [format/1]).

add(A,B) ->
    A + B.

hello() ->
    io:format("Hello, world!~n").

greet_and_add_two(X) ->
    hello(),
    add(X,2).