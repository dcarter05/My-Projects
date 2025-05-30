class Author:
    def __init__(self, fname: str, lname: str, mname: str, dob: str):
        self._Fname = fname
        self._Lname = lname
        self._Mname = mname
        self._DOB = dob

    def getFname(self) -> str:
        return self._Fname

    def setFname(self, fname: str) -> None:
        self._Fname = fname

    def getLname(self) -> str:
        return self._Lname

    def setLname(self, lname: str) -> None:
        self._Lname = lname

    def getMname(self) -> str:
        return self._Mname

    def setMname(self, mname: str) -> None:
        self._Mname = mname

    def getDOB(self) -> str:
        return self._DOB

    def setDOB(self, dob: str) -> None:
        self._DOB = dob

    def getName(self) -> str:
        return f"{self._Fname} {self._Mname} {self._Lname}"