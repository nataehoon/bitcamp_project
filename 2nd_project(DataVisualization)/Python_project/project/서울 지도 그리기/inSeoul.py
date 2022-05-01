import folium
import pandas as pd

df = pd.read_csv('Guincenter.csv', encoding='utf-8')
df_adm = df.groupby(['gu'])['su'].sum().to_frame().reset_index()
print(df.head())

print(df_adm.head())
geo_data = 'older_seoul.geojson'

center = [37.541, 126.986]
m = folium.Map(location=center, zoom_start=11.5, zoom_control=False, min_zoom=11)

folium.Choropleth(geo_data=geo_data, data=df_adm, columns=('gu', 'su'), key_on='feature.properties.구'
                  , fill_color='YlOrRd', legend_name='센터수').add_to(m)

m.save('c:/imsi/inSeoul.html')