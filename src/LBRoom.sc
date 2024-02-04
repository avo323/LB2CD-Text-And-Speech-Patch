;;; Sierra Script 1.0 - (do not remove this comment)
(script# 17)
(include sci.sh)
(use Main)
(use PolyPath)
(use Game)
(use User)
(use Obj)

(public
	eRS 0
)

(procedure (localproc_0390)
	(cond 
		((< (gEgo x?) 0) (gEgo x: (+ 0 (* (gEgo xStep?) 2))))
		((> (gEgo x?) 319) (gEgo x: (- 319 (* (gEgo xStep?) 2))))
	)
)

(procedure (localproc_03d6)
	(cond 
		((< (gEgo y?) (global2 horizon?)) (gEgo y: (+ (global2 horizon?) (* (gEgo yStep?) 2))))
		((> (gEgo y?) 189) (gEgo y: (- 189 (* (gEgo yStep?) 2))))
	)
)

(class LBRoom of Rm
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style $ffff
		horizon 15
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
	)
	
	(method (init param1 &tmp temp0 temp1 [temp2 2])
		(= number gNumber)
		(= gPicAngle picAngle)
		(if picture (self drawPic: picture))
		(cond 
			((not (gOldCast contains: gEgo)) 0)
			(script 0)
			((not ((User alterEgo?) edgeHit?)) 0)
			((proc999_5 style 11 12 13 14)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User alterEgo?) view?)
								((User alterEgo?) loop?)
								((User alterEgo?) cel?)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(/
							(CelHigh
								((User alterEgo?) view?)
								((User alterEgo?) loop?)
								((User alterEgo?) cel?)
							)
							2
						)
					)
				)
				(switch ((User alterEgo?) edgeHit?)
					(1 ((User alterEgo?) y: 188))
					(4
						((User alterEgo?) x: (- 319 temp0))
					)
					(3
						((User alterEgo?) y: (+ horizon temp1))
					)
					(2
						((User alterEgo?) x: (+ 0 temp0))
					)
				)
				((User alterEgo?) edgeHit: 0)
			)
			(else
				(if (not argc) (= param1 0))
				(self setScript: eRS param1 gGNumber)
			)
		)
		(if (gEgo scaler?) ((gEgo scaler?) doit:))
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script (script doit:))
			((!= gNumber gNewRoomNumber) 0)
			((not (gOldCast contains: gEgo)) 0)
			(
				(switch (= temp0 ((User alterEgo?) edgeHit?))
					(1 north)
					(2 east)
					(3 south)
					(4 west)
				)
				(self setScript: lRS 0 temp0)
			)
		)
	)
	
	(method (doVerb theVerb)
		(if (not (super doVerb: theVerb))
			(proc0_6 self theVerb)
		)
	)
	
	(method (setInset)
		(gIconBar disable: 7)
		(super setInset: &rest)
	)
)

(instance lRS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp1
					(CelWide (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(= temp0
					(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(switch register
					(1
						(global2 newRoom: (global2 north?))
					)
					(3
						(gEgo setMotion: PolyPath (gEgo x?) (+ 189 temp0) self)
						(= register (global2 south?))
					)
					(2
						(gEgo setMotion: PolyPath (+ 319 temp1) (gEgo y?) self)
						(= register (global2 east?))
					)
					(4
						(gEgo setMotion: PolyPath (- 0 temp1) (gEgo y?) self)
						(= register (global2 west?))
					)
				)
			)
			(1 (gEgo hide:) (= cycles 2))
			(2 (global2 newRoom: register))
		)
	)
)

(instance eRS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 0)
				(if (gUser canControl:) (gGame handsOff:))
				(= temp0
					(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(= temp1
					(CelWide (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(switch register
					((client north?)
						(localproc_0390)
						(gEgo y: (+ (global2 horizon?) (gEgo yStep?)))
						(= cycles 1)
					)
					((client south?)
						(localproc_0390)
						(gEgo
							y: (+ 189 temp0)
							setMotion: PolyPath (gEgo x?) (- 189 (* (gEgo yStep?) 2)) self
						)
					)
					((client east?)
						(localproc_03d6)
						(gEgo
							x: (+ 319 (/ temp1 2))
							setMotion: PolyPath (- 319 (* (gEgo xStep?) 2)) (gEgo y?) self
						)
					)
					((client west?)
						(localproc_03d6)
						(gEgo
							x: (- 0 (/ temp1 2))
							setMotion: PolyPath (+ 0 (* (gEgo xStep?) 2)) (gEgo y?) self
						)
					)
					(else  (= cycles 1))
				)
			)
			(1
				(gGame handsOn: 1)
				(self dispose:)
			)
		)
	)
)
