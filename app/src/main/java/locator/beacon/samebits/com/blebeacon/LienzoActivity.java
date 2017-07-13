package locator.beacon.samebits.com.blebeacon;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.print.PrintAttributes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;



public class LienzoActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    GridLayout lienzoImagenes;
    //Canvas canvas;

    private double resultadoFinal=0.0;

    private DecimalFormat formato = new DecimalFormat("#.###");
    /*private int[] matrizPromedio ={   0,0,0,0,0,0,0,0
                                     ,0,0,0,0,0,0,0,0
                                     ,0,0,0,0,0,0,0,0
                                     ,0,0,0,0,0,0,0,0
                                     ,0,0,0,0,0,0,0,0
                                     ,0,0,0,0,0,0,0,0
                                     ,0,0,0,0,0,0,0,0,
                                    -90,-91,-88,-87,-89,0,0,0};
                                    */

    private double[] casillasBeacon1={-92.75,-91.2 ,-90.8 ,-92.7 ,-90.55,-91.6 ,-96.85,-92.5 ,
                                      -94.5 ,-89.2 ,-87.8 ,-92.75,-100,-92.95,-91.2 ,-100.5,
                                      -91.5 ,-89.35,-88.7 ,-88.2 ,-91.6 ,-92.6 ,-90.75,-98.9 ,
                                      -91.75,-90.1 ,-90.2 ,-89.2 ,-88.85,-89   ,-97.85,-91.65,
                                      -88.9 ,-88.9, -89.85,-90.8 ,-87.55,-90.9 ,-93.3 ,-92.15,
                                      -87.3 ,-88.15,-91.25,-91.95,-91.4 ,-90.15,-92.1 ,-91.75,
                                      -88.85,-89.65,-89.2, -89.25,-90.2 ,-89.95,-90.3 ,-89.75,
                                      -86.85,-88.55,-90.75,-90.45,-88.35,-89.75,-90.05,-88.65};

    private double[] casillasBeacon2={-89.15,-92.35,-91   ,-88.25,-92.95,-92   ,-87.5 ,-93.6 ,
                                      -88   ,-87.8 ,-90.75,-91.45,-91.55,-90.15,-92.35,-91.55,
                                      -83   ,-90.45,-88   ,-90.5 ,-91.25,-95.25,-91.65,-88.4 ,
                                      -85.55,-89.3 ,-89.95,-90.6 ,-90   ,-91.95,-91.6 ,-88.8 ,
                                      -92.4 ,-90   ,-90.2 ,-90.25,-86.35,-90   ,-96.6 ,-97.1 ,
                                      -86.05,-88.25,-92.1 ,-91.55,-95.2 ,-90.35,-96.4 ,-90.9 ,
                                      -89.75,-90.55,-91.8 ,-90.6 ,-90.65,-90.3 ,-92.35,-94.85,
                                      -89.15,-91.35,-91   ,-91   ,-92   ,-90.9 ,-89.55,-91.2 };

    private double[] casillasBeacon3={-91.5 ,-92.65,-91.65,-86.65,-87.5 ,-81   ,-78.15,-84.1 ,
                                      -90.35,-90.85,-89.2 ,-84.6 ,-89.25,-92.3 ,-92.65,-89.25,
                                      -89.9 ,-87.55,-88   ,-86.85,-88.85,-84.75,-86   ,-85.65,
                                      -87.5 ,-89.15,-88   ,-87.65,-88.65,-90.75,-91.3 ,-90.45,
                                      -91.9 ,-89.05,-88.3 ,-91.7 ,-96.7 ,-88.1 ,-89.35,-90.65,
                                      -90.65,-87.4 ,-89.25,-91.85,-90.95,-89.25,-88.45,-91.45,
                                      -90.9 ,-92.3 ,-91.2 ,-89.3 ,-91.9 ,-89.4 ,-89.85,-91.6 ,
                                      -98.5 ,-91.85,-87.25,-91   ,-92.4 ,-90.95,-92   ,-89.7 };

    private double[] casillasBeacon4={-90.3 ,-92.9 ,-96.85,-101.5,-89.75,-93.35,-96.3 ,-100.4,
                                      -95.85,-91   ,-92.7 ,-92.5 ,-90.1 ,-89.05,-92.9 ,-90.1 ,
                                      -97.1 ,-92.9 ,-92   ,-89.75,-90.95,-90.85,-88.95,-89.45,
                                      -95.45,-90.95,-90.2 ,-88.4 ,-91.15,-89.5 ,-89.4 ,-87.55,
                                     -103.75,-90.3 ,-87.15,-90.55,-92.05,-91.3 ,-89.3 ,-80.25,
                                      -89.35,-89.65,-87.9 ,-89.45,-87.9 ,-89.65,-87.75,-84.8 ,
                                      -89.05,-89.7 ,-88.95,-93.55,-91.1 ,-85.35,-90.8 ,-84.35,
                                      -90.1 ,-91.7 ,-90   ,-86.95,-90.4 ,-85.85,-86.3 ,-82.85};

    private double[] casillasBeacon5={-87.1 ,-89.75,-88.8 ,-88.45,-88.6 ,-91.95,-88.15,-90.85,
                                      -90.3 ,-90.95,-88.85,-86.35,-102.4,-86.9 ,-89.75,-102.4,
                                      -87.3 ,-86.85,-79.75,-86.45,-91.65,-90.6 ,-89.9 ,-90.4 ,
                                      -87   ,-90.8 ,-88.9 ,-87.45,-89.3 ,-85.3 ,-89.65,-90.45,
                                      -89.5 ,-87.25,-87.75,-81.65,-86.65,-86.25,-88.4 ,-91.4 ,
                                      -86.4 ,-85.5 ,-80.4 ,-86.9 ,-88.85,-88.95,-92.2 ,-90.25,
                                      -89.75,-87   ,-87.95,-82.5 ,-90.7 ,-89.95,-89.75,-91.7 ,
                                      -89.9 ,-90.3 ,-85.25,-85.85,-83.35,-97.35,-91.1 ,-92   };
    ImageView[] imagenes= new ImageView[64];
    private HashMap<String, BTLE_Device> mBTDevicesHashMap;
    private ArrayList<BTLE_Device> mBTDevicesArrayList;
    private ArrayList<Integer> rssi_beacons;
    private ListAdapter_BTLE_Devices adapter;
    private Scanner_BTLE mBTLeScanner;
    private boolean isFinish=false;
    private BroadcastReceiver_BTState mBTStateUpdateReceiver;
    private String[] beaconsMacs ={"F1:82:F5:F1:79:E8","C0:62:E9:C5:37:F5","F7:D4:CF:09:98:F0","DD:BE:F9:A1:D8:99","D4:88:E6:45:E1:2B"};
    private int tiempoEscaneo =20000;
    private Handler mHandler;
    private int rssi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lienzo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHandler = new Handler();


        mBTStateUpdateReceiver = new BroadcastReceiver_BTState(getApplicationContext());
        mBTLeScanner = new Scanner_BTLE(this,tiempoEscaneo, -95 );
        mBTDevicesHashMap = new HashMap<>();
        mBTDevicesArrayList = new ArrayList<>();
        rssi_beacons= new ArrayList<>();



        /*=================================================================================================
                            Parte del codigo en donde pongo la matriz de las imagenes*/
        lienzoImagenes = (GridLayout)findViewById(R.id.lienzoImagen);

        for(int i=0;i<imagenes.length;i++)
        {
            imagenes[i] = new ImageView(getApplicationContext());
            imagenes[i].setPadding(1,1,1,1);
            imagenes[i].setImageResource(R.drawable.casilla);
            imagenes[i].setId(i);
            //Lugar donde pongo la accion que me marca en un toast los id de los imageView
            imagenes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int numero_casilla=0;
                    for(int i=0;i<imagenes.length;i++)
                    {
                        if(imagenes[i].getId()==view.getId())
                        {
                            numero_casilla=i;
                            break;
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Casilla: "+numero_casilla,Toast.LENGTH_SHORT).show();
                }
            });
            lienzoImagenes.addView(imagenes[i]);
        }

        /*===========================================================================================================
                            Pongo la accion para que empiece a localizar en el lienzo.*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0;i<imagenes.length;i++)
                {
                    imagenes[i].setImageResource(R.drawable.casilla);
                }

                startScan();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true)
                        {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if(isFinish==true)
                                    {
                                        /*
                                        Toast.makeText(getApplicationContext(), "Listo para calcular posicion", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(getApplicationContext(), "Checando...", Toast.LENGTH_SHORT).show();
                                        */
                                        double ResultadoRedondeado;
                                        int beacon1=rssi_beacons.get(0);
                                        int beacon2=rssi_beacons.get(1);
                                        int beacon3=rssi_beacons.get(2);
                                        int beacon4=rssi_beacons.get(3);
                                        int beacon5=rssi_beacons.get(4);
                                        int promedio=(beacon1+beacon2+beacon3+beacon4+beacon5)/5;

                                        Toast.makeText(getApplicationContext(),""+promedio, Toast.LENGTH_SHORT).show();

                                            if(promedio==-87)
                                            {
                                                for(int i=0;i<CMatrices.matriz1.length;i++) {

                                                    resultadoFinal = (Math.pow((promedio - casillasBeacon1[i]), 2)) + (Math.pow((promedio - casillasBeacon2[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon3[i]), 2)) + (Math.pow((promedio - casillasBeacon4[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon5[i]), 2));

                                                    if(formato.format(resultadoFinal).equals(CMatrices.matriz1[i]))
                                                    {
                                                        imagenes[i].setImageResource(R.drawable.circulo);
                                                        break;
                                                    }
                                                }
                                            }else if(promedio==-88)
                                            {
                                                for(int i=0;i<CMatrices.matriz2.length;i++) {

                                                    resultadoFinal = (Math.pow((promedio - casillasBeacon1[i]), 2)) + (Math.pow((promedio - casillasBeacon2[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon3[i]), 2)) + (Math.pow((promedio - casillasBeacon4[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon5[i]), 2));

                                                    if(formato.format(resultadoFinal).equals(CMatrices.matriz2[i]))
                                                    {
                                                        imagenes[i].setImageResource(R.drawable.circulo);
                                                        break;
                                                    }
                                                }
                                            }else if(promedio==-89)
                                            {
                                                for(int i=0;i<CMatrices.matriz3.length;i++) {

                                                    resultadoFinal = (Math.pow((promedio - casillasBeacon1[i]), 2)) + (Math.pow((promedio - casillasBeacon2[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon3[i]), 2)) + (Math.pow((promedio - casillasBeacon4[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon5[i]), 2));

                                                    if(formato.format(resultadoFinal).equals(CMatrices.matriz3[i]))
                                                    {
                                                        imagenes[i].setImageResource(R.drawable.circulo);
                                                        break;
                                                    }
                                                }
                                            }
                                            /*
                                            else if(promedio==-90)
                                            {
                                                for(int i=0;i<CMatrices.matriz3.length;i++) {

                                                    resultadoFinal = (Math.pow((promedio - casillasBeacon1[i]), 2)) + (Math.pow((promedio - casillasBeacon2[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon3[i]), 2)) + (Math.pow((promedio - casillasBeacon4[i]), 2)) +
                                                            (Math.pow((promedio - casillasBeacon5[i]), 2));

                                                    if(formato.format(resultadoFinal).equals(CMatrices.matriz3[i]))
                                                    {
                                                        imagenes[i].setImageResource(R.drawable.circulo);
                                                        break;
                                                    }
                                                }
                                            }
                                            */

                                        Toast.makeText(getApplicationContext(),""+formato.format(resultadoFinal), Toast.LENGTH_SHORT).show();
                                        isFinish=false;
                                    }
                                }
                            });
                            if(isFinish==true)
                            {
                                Thread.interrupted();
                                break;
                            }
                        }
                    }
                }).start();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //RelativeLayout layout = (RelativeLayout)findViewById(R.id.relativeLienzo);

        //layout.addView(canvas);
    }

    public void startScan(){


        mBTDevicesArrayList.clear();
        mBTDevicesHashMap.clear();
        rssi_beacons.clear();

//        adapter.notifyDataSetChanged();

        mBTLeScanner.startLienzo();
    }

    public void stopScan() {

        mBTLeScanner.stop();
        isFinish=true;
    }

    public void addDevice(BluetoothDevice device, int rssi) {

        String address = device.getAddress();
        for(int i=0;i<beaconsMacs.length;i++)
        {
            if (address.equals(beaconsMacs[i])){
                if (!mBTDevicesHashMap.containsKey(address)) {
                    BTLE_Device btleDevice = new BTLE_Device(device);
                    btleDevice.setRSSI(rssi);
                    mBTDevicesHashMap.put(address, btleDevice);
                    mBTDevicesArrayList.add(btleDevice);
                    rssi_beacons.add(rssi);
                }
                else {
                    mBTDevicesHashMap.get(address).setRSSI(rssi);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lienzo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            // Handle the camera action
            Intent inicio = new Intent(getApplicationContext(),navigation_activity.class);
            startActivity(inicio);
        } else if (id == R.id.nav_Escanear) {

            Intent escanear = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(escanear);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
