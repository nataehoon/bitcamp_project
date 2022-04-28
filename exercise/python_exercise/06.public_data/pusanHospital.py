import json, urllib.request, datetime, math

def getRequestUrl(url):
    req = urllib.request.Request(url)
    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            # print ("[%s] Url Request Success" % datetime.datetime.now())
            return response.read().decode('utf-8')
    except Exception as e:
        # print(e)
        print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
        return None
# end def getRequestUrl

def getHospitalData(pageNo, numOfRows):
    end_point = 'http://apis.data.go.kr/6260000/MedicInstitService/MedicalInstitInfo'
    #
    # 일반 인증키
    access_key = '3KGqgdUk5pDAmKdENbpn40rRa4V2pQeLsIbCdrYyPXf8IM9W5%2FUNGRUigLpn23ZS6UhWqx7vc2T1WAYK2MNGYg%3D%3D'

    parameters = ''
    parameters += "?resultType=json"  #
    parameters += "&serviceKey=" + access_key
    parameters += "&pageNo=" + str(pageNo) # 페이지 번호
    parameters += "&numOfRows=" + str(numOfRows) # 조회 최대 행수(레코드 수)
    url = end_point + parameters

    print('유알엘')
    print(url)

    result = getRequestUrl(url)
    if (result == None):
        return None
    else:
        return json.loads(result)
# end def getHospitalData

jsonResult = []

pageNo = 1 # 페이지 번호
numOfRows = 100 # 조회 레코드(행)의 최대 수
nPage = 0
while(True):#
    print('pageNo : %d, nPage : %d' % (pageNo, nPage))
    jsonData = getHospitalData(pageNo, numOfRows)
    print(jsonData)

    if (jsonData['MedicalInstitInfo']['header']['code'] == '00'):
        totalCount = jsonData['MedicalInstitInfo']['totalCount']
        print('데이터 총 갯수 : ', totalCount)  # 전체 조회된 결과 수

        for item in jsonData['MedicalInstitInfo']['item']:
            jsonResult.append(item)

        if totalCount == 0:
            break
        nPage = math.ceil(totalCount / numOfRows)
        if (pageNo == nPage): # if (pageNo == nPage or pageNo == 10):
            break # 마지막 페이지에 도달했어요.

        pageNo += 1
    else :
        break
    # end while

    savedFilename = '부산시 의료기관, 약국 운영시간 정보.json'
    with open(savedFilename, 'w', encoding='utf8') as outfile:
        retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
        outfile.write(retJson)

    print(savedFilename + '이 저장되었습니다.')