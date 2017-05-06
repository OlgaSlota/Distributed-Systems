from __future__ import print_function

import grpc
import sys
import hospital_pb2
import hospital_pb2_grpc


def run():
  channel = grpc.insecure_channel('localhost:50051')
  stub = hospital_pb2_grpc.HospitalStub(channel)

  print("Please type your login : ")
  login = sys.stdin.readline().strip()
  while True:
      print("Please type patient's name : ")
      name = sys.stdin.readline().strip()
      print("Please type patient's pesel : ")
      pesel = sys.stdin.readline().strip()
      print("Please type patient's address : ")
      address = sys.stdin.readline().strip()
      print("Please type doctor name : ")
      doctor = sys.stdin.readline().strip()

      print("Please type parameters list or \"q\" if finished: ")

      paramName=[]
      paramValue=[]
      paramUnit=[]
      input =""

      while input!="q":
          print("Please type parameter name: ")
          paramName.append(sys.stdin.readline().strip())
          print("Please type parameter value: ")
          try:
              paramValue.append(float(sys.stdin.readline().strip()))
          except Exception as e:
              print("exception while parsing value to float , try again: " )
              paramValue.append(float(sys.stdin.readline().strip()))

          print("Please type parameter unit: ")
          paramUnit.append(sys.stdin.readline().strip())
          input = sys.stdin.readline().strip()

      try:
          response = stub.SavePatientResults(hospital_pb2.PatientRecord(name=name, pesel=pesel, address=address,
                           doctor=doctor,paramName=paramName, paramValue=paramValue,paramUnit=paramUnit))
          print("Patient record saved with status " + str(response.status))
      except:
          print("Connection to server failed\n")

if __name__ == '__main__':
  run()
