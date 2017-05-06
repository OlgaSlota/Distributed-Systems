from __future__ import print_function

import grpc
import sys
import hospital_pb2
import hospital_pb2_grpc


def run():
  channel = grpc.insecure_channel('localhost:50051')
  stub = hospital_pb2_grpc.HospitalStub(channel)

  while(True):
      print("Please type your PESEL number : ")
      for line in sys.stdin:
          try:
              response = stub.ShowPatientCard(hospital_pb2.ShowPatientArgument(pesel=line.strip()))
              if response.name != "":
                  print("Patient record received: \nname: " +response.name+", pesel: "+ response.pesel + "\nresults: ")
                  for i in range(len(response.paramName)):
                    print(response.paramName[i] + " _ " + str(response.paramValue[i]) + " _ " + response.paramUnit[i])
              else:
                  print("No records found")
          except:
              print("Connection to server failed")

          print("\nPlease type your PESEL number : ")


if __name__ == '__main__':
  run()
